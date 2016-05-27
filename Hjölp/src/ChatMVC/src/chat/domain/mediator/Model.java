package chat.domain.mediator;

import chat.domain.model.Message;

public interface Model
{
   public void addMessage(Message message);
   public void notifyAboutMessage(Message message);
}
