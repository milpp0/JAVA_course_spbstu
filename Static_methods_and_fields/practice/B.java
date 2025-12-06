package practice;

class B extends A {
    public static void callParentStatic() {
        A.printVars();  // через имя родительского класса
        printVars();    // напрямую (наследуется)
        B.printVars();  // через имя своего класса
    }
}