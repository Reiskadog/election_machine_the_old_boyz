package model;

public class RankingModel {
	private Long id;
	private Long questionId;
	private Integer rank;
	private String time;

	public RankingModel(Long id, Long questionId, Integer rank, String time) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.rank = rank;
		this.time = time;
	}

	public RankingModel() {
	}

	public RankingModel(Long questionId, Integer rank, String time) {
		super();
		this.questionId = questionId;
		this.rank = rank;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
