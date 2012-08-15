package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.Task;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	final static Form<Task> taskForm = form(Task.class);

	public static Result index() {
		return ok(index.render("Tasks App.", taskForm));
	}

	public static Result addTask() {

		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(index.render("Task Error", taskForm));
		} else {
			Task task = new Task(); 
			task=filledForm.get();
			task.save();
			return redirect(routes.Application.index());
	}
		}
	
	

	public static Result getTasks() {
		List<Task> tasks = new Model.Finder(String.class, Task.class).all();
		return ok(toJson(tasks));
	}

}