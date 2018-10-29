package gamedevelopers.funcandi.taskworkflow.game1;

/**
 * Created by hp on 13-06-2017.
 */
import android.graphics.Canvas;

public class GameLoopThread extends Thread {
    static final long FPS = 10;

    private GameView view;
    private final Object pauseLock = new Object();

    private boolean running = false,paused=false;



    public GameLoopThread(GameView view) {

        this.view = view;

    }



    public void setRunning(boolean run) {

        running = run;

    }



    public void run() {

        long ticksPS = 1000 / FPS;

        long startTime;

        long sleepTime;

        while (running) {
            synchronized (pauseLock) {
                if (!running) { // may have changed while waiting to
                    // synchronize on pauseLock
                    break;
                } if (paused) {
                    try {
                        pauseLock.wait(); // will cause this Thread to block until
                        // another thread calls pauseLock.notifyAll()
                        // Note that calling wait() will
                        // relinquish the synchronized lock that this
                        // thread holds on pauseLock so another thread
                        // can acquire the lock to call notifyAll()
                        // (link with explanation below this code)
                    } catch (InterruptedException ex) {
                        break;
                    }
                    if (!running) { // running might have changed since we paused
                        break;
                    }
                }
            }
            Canvas c = null;

            startTime = System.currentTimeMillis();

            try {

                c = view.getHolder().lockCanvas();

                synchronized (view.getHolder()) {

                    view.onDraw(c);
                    view.update();

                }

            } finally {

                if (c != null) {

                    view.getHolder().unlockCanvasAndPost(c);

                }

            }

            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);

            try {

                if (sleepTime > 0)

                    sleep(sleepTime);

                else

                    sleep(10);

            } catch (Exception e) {}

        }

    }

    public void onpause() {
        // you may want to throw an IllegalStateException if !running
        paused = true;
        //view.stopView();

    }

    public void onresume() {
        synchronized (pauseLock) {
            //setRunning(true);
            paused = false;
            pauseLock.notifyAll(); // Unblocks thread
        }
    }

}