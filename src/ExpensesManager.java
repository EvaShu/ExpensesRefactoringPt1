import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {

    HashMap<String, ArrayList<Double>> expensesByCategories; // объявили таблицу с именем expensesByCategories
    ArrayList<Double> expenses;  // объявили эррей Траты

    ExpensesManager() {

        expensesByCategories = new HashMap<>(); //создали объект таблицы

        expenses = new ArrayList<>();
        expenses.add(200.30);
        expenses.add(122.65);
        expenses.add(302.87);
        expenses.add(33.97);
        expensesByCategories.put("Дом", expenses);

        expenses = new ArrayList<>();
        expenses.add(700.40);
        expensesByCategories.put("Здоровье", expenses);

        expenses = new ArrayList<>();
        expenses.add(1300.56);
        expenses.add(800.00);
        expensesByCategories.put("Еда", expenses);

    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense; //считает новый остаток, вычитая из него трату
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // Замените на работу с таблицей //добавляет трату в указанную пользователем категорию
        if (expensesByCategories.containsKey(category)) { //если категория есть в таблице
            expensesByCategories.get(category); // получаем Эррей трат этой категории
            (expensesByCategories.get(category)).add(expense); // добавляем введенную пользователем трату в Эррей категории
        } else {
            expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
            // Создайте новый список трат и добавьте в него сумму
            // Сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String cat : expensesByCategories.keySet()) { // Проходится по ключам
            System.out.println(cat);
            for (Double y : expensesByCategories.get(cat)) { //Проходит по каждой трате в каждой категории
                System.out.println(y);//печатаем
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) { //если таблица содержит конкретный ключ-категорию
            for (Double y : expensesByCategories.get(category)) { //то проходим по каждому значению типа Дабл в Эррее этой категории
                if (y > maxExpense) { // если этот Дабл больше МаксЭкспенс
                    maxExpense = y;// то он становится МаксЭкпенс
                }
            }
            return maxExpense;
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }


    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}
