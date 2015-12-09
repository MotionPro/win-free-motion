import java.util.Objects;

/**
 * Created by Carlos Padilla III on 11/20/2015.
 */
//Functional Interface = interface with one method.
interface Executable {
    int execute(int a, int b);
}

interface StringExecutable {
    int execute(String a);
}


class Runner{
    public void run(Executable e){
        System.out.println("Executing code block ....");
        int value = e.execute(12, 13);
        System.out.println("Return value is: " + value);
    }

    public void run(StringExecutable e){
        System.out.println("Executing code block ....");
        int value = e.execute("Hello");
        System.out.println("Return value is: " + value);
    }


}
// () -> System.out.println("Passing Code Block.")

public class App {
    public static void main(String[] args) {

        final int c = 100;
        // Cant do this: c = 8;

        int d = 77;

        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public int execute(int a, int b) {
                System.out.println("Passing Code Block.");
                // Can do this, since d is a new variable
                // with it's own scope: int d = 8;
                return a + b + c;
            }
        });

        System.out.println("====================\n");


        // Passing 1 expression
        //runner.run(() -> System.out.println("Passing Code Block.\n"));

        // Passing a Block of code
        /*runner.run(() -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
        });
        */

        // Passing a Block of code w/ a return type
        /*runner.run(() -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
            return 8;
        });
        */

       // System.out.println();

        // Passing just a return type
        /*runner.run(() -> {
            return 8;
        });
        */

        //System.out.println();

        // Passing just a return type
        //runner.run(() -> 8 );

        // Passing a Parameter with a return type
        /*runner.run((int a) -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
            return 7 + a;
        });
        */

        // Passing  Multiple Parameter with a return type
        runner.run((int a, int b) -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
            // Can't do this, no new scope!!: int d = 8;
            return a + b + c;
        });

        System.out.println("==============================\n");

        // Lambda Expressions can be treated as Objects!!
        Executable ex = (int a, int b) -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
            // Can't do this, no new scope!!: int d = 8;
            return a + b + c;
        };

        runner.run(ex);

        Object codeblock = (Executable)(int a, int b) -> {
            System.out.println("This is a Lambda Expression that is");
            System.out.println("Passing Code Block.");
            System.out.println("=====================");
            // Can't do this, no new scope!!: int d = 8;
            return a + b + c;
        };


    }
}
