package ru.netology.javacore;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class TodosTests {

    Todos sut;

    @BeforeEach
    public void init() {
        sut = new Todos();
    }

    @BeforeAll
    public static void start() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void finish() {
        System.out.print("Tests are over");
    }

    @Test
    public void addTaskTestVerify() {
        Todos todos = Mockito.spy(Todos.class);
        todos.addTask("To go for a walk");
        Mockito.verify(todos).addTask("To go for a walk");
    }

    @Test
    public void removeTaskTestVerify() {
        Todos todos = Mockito.spy(Todos.class);
        todos.removeTask("To go for a walk");
        Mockito.verify(todos).removeTask("To go for a walk");
    }

    @Test
    public void getAllTasksTest() {
        String oneTask = "To solve the task";
        String twoTask = "Go to bed";
        String threeTask = "Have dinner";
        String expected = "Go to bed Have dinner To solve the task";

        sut.addTask(oneTask);
        sut.addTask(twoTask);
        sut.addTask(threeTask);
        String result = sut.getAllTasks();

        Assertions.assertEquals(expected, result);
    }
}
