package apipack.multithreadwritefile;

public class TestWrite {

    /**
     * @param args
     */
    public static void main(String[] args) {

//		test();
        test02();
    }

    private static void test02() {
        WriteTask_New write = new WriteTask_New();
        for (int i = 0; i < 4; i++) {
            new Thread(write).start();
        }

        OutputTask output = new OutputTask("abc.txt");
        output.run();
//        new Thread(output).start();
    }

}
