package com.webdevelopment.developweb;

import java.util.ArrayList;
import java.util.List;

public class Data {

	public static List<Post> posts = new ArrayList<Post>();
	
	public static List<Users> users = new ArrayList<Users>();
	
	static{
		posts.add(new Post("title1","content1"));
		posts.add(new Post("title2","content2"));
	}
	
	static{
		users.add(new Users("mark","beyond"));
	}

	public static Post getById(long id) {
		for(Post p:posts){
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return new Post("NO Found!","NO Found!");
	}
}
