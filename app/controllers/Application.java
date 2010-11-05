package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;

import java.util.*;

import models.*;
//TODO make POST work
public class Application extends Controller {
    public static void index() {
		render();
    }

    static void addNick(String nickname) {
    	Cache.init();
		Cache.set(session.getId(), nickname);
    }

	public static void addMsg() {
		String message = params.get("message");
		String nick = params.get("nick");
		if (message == null)
    		message = "";
    	Message msg;
		msg = new Message(nick,message);
		msg.save();
		render(msg);
		index();
	}
	
    public static void show(){
		Cache.init();
		Date date=(Date)Cache.get(session.getId());
		if(date==null ) {
		date = new Date();
		Cache.set(session.getId(),date);
		}
    	List <Message> msg = Message.find("select p from Message p where p.timestamp > ?",date).fetch();
		System.out.println(date);
		if (!msg.isEmpty() && msg.size()!=0)
			date=msg.get(msg.size()-1).timestamp;
		Cache.set(session.getId(),new Date());
		render(msg);
		}
	public static void showAll(){
		List <Message> msg = Message.findAll();
		render(msg);
	}
    public static void clear() {
    	Cache.clear();
    	render();
	}
}