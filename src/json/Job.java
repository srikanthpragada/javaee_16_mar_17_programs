package json;

public class Job {
	private String id, title;

	public Job(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + "]";
	}

}
