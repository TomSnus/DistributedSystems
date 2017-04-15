package server;

public interface IChatMessageHub {
	public void addChatListener(IChatListener listener);
	public void removeChatListener(IChatListener listener);
	public void publish(String fromUser, String message, boolean isAdmin);
}
