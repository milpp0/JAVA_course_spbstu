package practice;

/**
 * Практика по созданию пользовательских исключений.
 * Демонстрирует создание собственного класса исключения с тремя конструкторами.
 */
public class Practice9_4 {

    /**
     * Собственный класс исключения для обработки ошибок банковского счета.
     * Наследуется от Exception для создания проверяемого исключения.
     * По договоренности имя класса заканчивается на "Exception".
     */
    static class BankAccountException extends Exception {
        
        /**
         * Конструктор 1: Без параметров.
         * Создает исключение с сообщением по умолчанию.
         */
        public BankAccountException() {
            super("Ошибка банковского счета");
        }
        
        /**
         * Конструктор 2: С сообщением об ошибке.
         * 
         * @param message детальное сообщение об ошибке
         */
        public BankAccountException(String message) {
            super(message);
        }
        
        /**
         * Конструктор 3: С сообщением и причиной.
         * Позволяет создать цепочку исключений.
         * 
         * @param message детальное сообщение об ошибке
         * @param cause исходное исключение, которое вызвало эту ошибку
         */
        public BankAccountException(String message, Throwable cause) {
            super(message, cause);
        }
        
        // Дополнительные методы можно добавить при необходимости
        // Например, методы для получения дополнительной информации об ошибке
    }
    
    /**
     * Второй пример: Исключение для ошибок при переводе денег.
     * Демонстрирует использование дополнительных полей в исключении.
     */
    static class MoneyTransferException extends Exception {
        private final double amount;
        private final String fromAccount;
        private final String toAccount;
        
        /**
         * Конструктор с дополнительной информацией о переводе.
         * 
         * @param message сообщение об ошибке
         * @param amount сумма перевода
         * @param fromAccount счет отправителя
         * @param toAccount счет получателя
         */
        public MoneyTransferException(String message, double amount, 
                                     String fromAccount, String toAccount) {
            super(message);
            this.amount = amount;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }
        
        /**
         * Конструктор с причиной и дополнительной информацией.
         */
        public MoneyTransferException(String message, double amount, 
                                     String fromAccount, String toAccount, Throwable cause) {
            super(message, cause);
            this.amount = amount;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }
        
        // Геттеры для доступа к дополнительной информации
        public double getAmount() {
            return amount;
        }
        
        public String getFromAccount() {
            return fromAccount;
        }
        
        public String getToAccount() {
            return toAccount;
        }
        
        /**
         * Переопределенный метод для вывода дополнительной информации.
         */
        @Override
        public String getMessage() {
            return super.getMessage() + 
                   String.format(" [Сумма: %.2f, От: %s, Кому: %s]", 
                                amount, fromAccount, toAccount);
        }
    }
    
    /**
     * Класс, имитирующий банковский счет.
     */
    static class BankAccount {
        private String accountNumber;
        private double balance;
        
        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }
        
        /**
         * Метод для снятия денег со счета.
         * 
         * @param amount сумма для снятия
         * @throws BankAccountException если сумма превышает баланс
         */
        public void withdraw(double amount) throws BankAccountException {
            if (amount > balance) {
                throw new BankAccountException(
                    String.format("Недостаточно средств на счете %s. Баланс: %.2f, Запрошено: %.2f",
                                 accountNumber, balance, amount));
            }
            balance -= amount;
            System.out.printf("Со счета %s снято: %.2f. Новый баланс: %.2f%n",
                            accountNumber, amount, balance);
        }
        
        /**
         * Метод для перевода денег на другой счет.
         * 
         * @param toAccount счет получателя
         * @param amount сумма перевода
         * @throws MoneyTransferException если перевод невозможен
         */
        public void transfer(String toAccount, double amount) throws MoneyTransferException {
            try {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Сумма перевода должна быть положительной");
                }
                
                if (amount > balance) {
                    throw new MoneyTransferException(
                        "Недостаточно средств для перевода", 
                        amount, this.accountNumber, toAccount);
                }
                
                // Имитация других возможных ошибок
                if (toAccount == null || toAccount.trim().isEmpty()) {
                    throw new MoneyTransferException(
                        "Неверный номер счета получателя", 
                        amount, this.accountNumber, toAccount);
                }
                
                balance -= amount;
                System.out.printf("Перевод %.2f со счета %s на счет %s. Новый баланс: %.2f%n",
                                amount, this.accountNumber, toAccount, balance);
                
            } catch (IllegalArgumentException e) {
                // Создаем цепочку исключений
                throw new MoneyTransferException(
                    "Ошибка при переводе: " + e.getMessage(),
                    amount, this.accountNumber, toAccount, e);
            }
        }
        
        public double getBalance() {
            return balance;
        }
        
        public String getAccountNumber() {
            return accountNumber;
        }
    }

    /**
     * Главный метод для демонстрации использования пользовательских исключений.
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация пользовательских исключений ===\n");
        
        // Создаем банковский счет
        BankAccount account = new BankAccount("123456789", 1000.00);
        
        System.out.println("1. Демонстрация базового пользовательского исключения:");
        System.out.printf("Баланс счета %s: %.2f%n%n", account.getAccountNumber(), account.getBalance());
        
        try {
            // Попытка снять деньги - успешно
            account.withdraw(500.00);
            
            // Попытка снять больше, чем есть на счете
            account.withdraw(600.00);
            
        } catch (BankAccountException e) {
            System.out.println("Перехвачено BankAccountException:");
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Тип: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n---\n");
        
        System.out.println("2. Демонстрация исключения с дополнительными полями:");
        System.out.printf("Баланс счета %s: %.2f%n%n", account.getAccountNumber(), account.getBalance());
        
        try {
            // Успешный перевод
            account.transfer("987654321", 200.00);
            
            // Попытка перевода с ошибкой
            account.transfer("", 400.00);
            
        } catch (MoneyTransferException e) {
            System.out.println("\nПерехвачено MoneyTransferException:");
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Сумма: " + e.getAmount());
            System.out.println("  От счета: " + e.getFromAccount());
            System.out.println("  На счет: " + e.getToAccount());
            System.out.println("  Тип: " + e.getClass().getSimpleName());
            
            // Проверяем, есть ли причина
            if (e.getCause() != null) {
                System.out.println("  Причина: " + e.getCause().getClass().getSimpleName());
                System.out.println("  Сообщение причины: " + e.getCause().getMessage());
            }
        }
        
        System.out.println("\n---\n");
        
        System.out.println("3. Демонстрация разных конструкторов:");
        
        try {
            // Использование конструктора без параметров
            throw new BankAccountException();
            
        } catch (BankAccountException e) {
            System.out.println("Конструктор без параметров: " + e.getMessage());
        }
        
        try {
            // Использование конструктора с сообщением
            throw new BankAccountException("Произошла ошибка при обработке счета");
            
        } catch (BankAccountException e) {
            System.out.println("Конструктор с сообщением: " + e.getMessage());
        }
        
        try {
            // Использование конструктора с причиной (цепочка исключений)
            try {
                int result = 10 / 0; // ArithmeticException
            } catch (ArithmeticException cause) {
                throw new BankAccountException("Ошибка при расчетах", cause);
            }
            
        } catch (BankAccountException e) {
            System.out.println("Конструктор с причиной: " + e.getMessage());
            System.out.println("Причина: " + e.getCause().getClass().getSimpleName());
        }
        
        System.out.println("\n=== Конец демонстрации ===");
    }
}