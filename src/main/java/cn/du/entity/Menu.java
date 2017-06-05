package cn.du.entity;

import java.util.HashSet;
import java.util.Set;

public class Menu implements java.io.Serializable {

	// Fields

	private String id;
	private Menu tmenu;
	private String text;
	private String iconcls;
	private String url;
	private Set<Menu> tmenus = new HashSet<Menu>(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Menu getTmenu() {
		return this.tmenu;
	}

	public void setTmenu(Menu tmenu) {
		this.tmenu = tmenu;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Menu> getTmenus() {
		return this.tmenus;
	}

	public void setTmenus(Set<Menu> tmenus) {
		this.tmenus = tmenus;
	}
}