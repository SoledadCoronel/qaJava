package testPostActions;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//Se instancia cada objeto de cada clase
		PostOk post = new PostOk();
		LikePostOk like = new LikePostOk();
		SharePostCancel shareCancel = new SharePostCancel();
		SharePostOk shareOk = new SharePostOk();
		CommentPostOk commentOk = new CommentPostOk();
		DeleteCommentPostOk deleteCommentOk = new DeleteCommentPostOk();
		DeletePostCancel deleteCancel = new DeletePostCancel();
		DeletePostOk deleteOk = new DeletePostOk();
		PostLinkOk postLink = new PostLinkOk();
		PostLinkDeleteOk deleteLink = new PostLinkDeleteOk();
		
		// Se llaman en suite a cada unos de los métodos para testear todas las acciones de forma consecutiva
		post.testPost();
		like.likePost();
		shareCancel.sharePostCnl();
		shareOk.sharePost();
		commentOk.testComment();
		deleteCommentOk.testDeleteComment();
		deleteCancel.deletePostCnl();
		deleteOk.deletePost();
		postLink.testPostLink();
		deleteLink.testDeleteLink();
	}
}
