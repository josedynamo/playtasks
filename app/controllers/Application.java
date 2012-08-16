package controllers;

import play.*;

import static play.libs.Json.toJson;

import java.util.List;

import models.Task;
import play.data.*;
import play.db.*;
import play.db.ebean.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	final static Form<Task> taskForm = form(Task.class);

	public static Result index() {
		return ok(index.render("Tasks App.", taskForm));
	}

	public static Result addTask() {

		Form<Task> filledForm = form(Task.class).bindFromRequest();
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