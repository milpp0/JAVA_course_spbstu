package practice;

/**
 * Примеры
 */
public class Practice5_1 {
    
    // Практика 1: Спецификаторы доступа
    class Outer1 {
        public class PublicInner {}
        protected class ProtectedInner {}
        class PackageInner {} // default
        private class PrivateInner {}
    }
    
    // Практика 2: Доступ изнутри наружу
    class Outer2 {
        private String privateField = "private";
        protected String protectedField = "protected";
        public String publicField = "public";
        String packageField = "package"; // default
        
        class Inner2 {
            void show() {
                // Доступ ко всем полям Outer2
                System.out.println(privateField);
                System.out.println(protectedField);
                System.out.println(publicField);
                System.out.println(packageField);
            }
        }
    }
    
    // Практика 3: Доступ снаружи вовнутрь
    class Outer3 {
        class Inner3 {
            public String publicField = "public";
            protected String protectedField = "protected";
            private String privateField = "private";
            String packageField = "package"; // default
            
            public void publicMethod() {}
            protected void protectedMethod() {}
            private void privateMethod() {}
            void packageMethod() {} // default
        }
        
        void testAccess() {
            Inner3 inner = new Inner3();
            
            // Доступ из Outer3 к Inner3
            System.out.println(inner.publicField);    // ДА
            System.out.println(inner.protectedField); // ДА
            // System.out.println(inner.privateField); // НЕТ
            System.out.println(inner.packageField);   // ДА
            
            inner.publicMethod();     // ДА
            inner.protectedMethod();  // ДА
            // inner.privateMethod(); // НЕТ
            inner.packageMethod();    // ДА
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ОТВЕТЫ ===\n");
        
        Practice5_1 demo = new Practice5_1();
        
        System.out.println("1. СПЕЦИФИКАТОРЫ ДОСТУПА:");
        System.out.println("   • public - доступен везде");
        System.out.println("   • protected - в пакете + наследники");
        System.out.println("   • package - только в пакете");
        System.out.println("   • private - только во внешнем классе");
        
        System.out.println("\n2. ДОСТУП ИЗ ВНУТРЕННЕГО КЛАССА ВО ВНЕШНИЙ:");
        System.out.println("   • Внутренний класс имеет доступ ко ВСЕМ");
        System.out.println("     полям и методам внешнего класса");
        System.out.println("   • Даже к private!");
        System.out.println("   • Пример: Inner может читать privateField Outer");
        
        System.out.println("\n3. ДОСТУП ИЗ ВНЕШНЕГО КЛАССА ВО ВНУТРЕННИЙ:");
        System.out.println("   • Внешний класс имеет доступ согласно");
        System.out.println("     обычным правилам Java:");
        System.out.println("   • public - ДА");
        System.out.println("   • protected - ДА (в том же классе)");
        System.out.println("   • package - ДА");
        System.out.println("   • private - НЕТ");
        System.out.println("   • Пример: Outer может читать publicField Inner");
        System.out.println("     но не может читать privateField Inner");
        
        // Быстрая демонстрация
        Outer2 outer2 = demo.new Outer2();
        Outer2.Inner2 inner2 = outer2.new Inner2();
        System.out.println("\nДемонстрация доступа из Inner в Outer:");
        inner2.show();
        
        Outer3 outer3 = demo.new Outer3();
        System.out.println("\nДемонстрация доступа из Outer в Inner:");
        outer3.testAccess();
    }
}