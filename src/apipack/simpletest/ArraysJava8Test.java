package apipack.simpletest;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/2/12 上午11:08.
 */
public class ArraysJava8Test {

    {
        System.out.println("this is test");
    }

    public static void main(String[] args) {

//        ArraysJava8Test arraysJava8Test = new ArraysJava8Test();

        Apple apple = new Apple("iPhone", "iPad", "MacBook Pro");

        System.out.println(apple);

        int[] intArr = {3, 1, 5, 7, 8, 9};

        System.out.println(Arrays.toString(intArr));

        Arrays.parallelPrefix(intArr, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });

        System.out.println(Arrays.toString(intArr));

//        Arrays.parallelPrefix(intArr, new IntBinaryOperator();

        Arrays.parallelSetAll(intArr, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });

        System.out.println(Arrays.toString(intArr));


    }


}

class Apple {

    private String phone;
    private String pad;
    private String personalComputer;


    public Apple(String phone, String pad, String personalComputer) {
        this.phone = phone;
        this.pad = pad;
        this.personalComputer = personalComputer;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "phone='" + phone + '\'' +
                ", pad='" + pad + '\'' +
                ", personalComputer='" + personalComputer + '\'' +
                '}';
    }

    public class iPhone {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPad() {
        return pad;
    }

    public void setPad(String pad) {
        this.pad = pad;
    }

    public String getPersonalComputer() {
        return personalComputer;
    }

    public void setPersonalComputer(String personalComputer) {
        this.personalComputer = personalComputer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(phone, apple.phone) &&
                Objects.equals(pad, apple.pad) &&
                Objects.equals(personalComputer, apple.personalComputer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phone, pad, personalComputer);
    }
}
