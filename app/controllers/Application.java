package controllers;

import models.Task;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Tasks App."));
  }
  
  public static Result addTask(){
	  Form<Task> form = form(Task.class).bindFromRequest();
	  Task task = form.get();
	  task.save();
	  return redirect(routes.Application.index());
  }
  
}