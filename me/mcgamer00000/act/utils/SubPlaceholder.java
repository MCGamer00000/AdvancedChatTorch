package me.mcgamer00000.act.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class SubPlaceholder {

	String name;
	int priority;
	String perm;
	String value;
	String hover;
	String suggest;
	String run;
	boolean isText = false;
	
	public boolean isText() {
		return isText;
	}

	public SubPlaceholder(String name, ConfigurationSection section) {
		this.name = name;
		this.priority = section.getInt("priority");
		this.perm = section.getString("perm");
		this.value = section.getString("value");
		if(section.contains("hoverText")) 
			hover = section.getString("hoverText");
		if(section.contains("suggestCmd"))
			suggest = section.getString("suggestCmd");
		if(section.contains("runCmd")) 
			run = section.getString("runCmd");
		if(section.contains("useGroupEvents")) {
			if(section.getBoolean("useGroupEvents")) 
				isText = true;
		}
	}

	public String getHover() {
		return hover;
	}

	public String getSuggest() {
		return suggest;
	}

	public String getRun() {
		return run;
	}
	
	public boolean hasHover() {
		return hover != null;
	}
	
	public boolean hasSuggest() {
		return suggest != null;
	}
	
	public boolean hasRun() {
		return run != null;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public String getPerm() {
		return perm;
	}
	
	public boolean hasPerm(Player p) {
		return perm.equals("") || p.hasPermission(perm);
	}

	public String getValue() {
		return value;
	}

}
