package apipack.multithreadwritefile;

public class WriteTask_New implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//			try {
//				sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
            System.out.println("begin write");
            WriterQueue.getQueue().put("for:" + i + " thread:" + Thread.currentThread().getName());
            System.out.println("end write");
        }
    }

    private void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
