package test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import static org.fest.assertions.Assertions.assertThat;

import models.Task;

import org.junit.Test;

public class TaskTest {

	@Test
	public void create() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				Task task = new Task();
				task.contents = "Some string";
				task.save();
				assertThat(task.Id).isNotNull();
			}
		});
	}

}
