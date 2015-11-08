package fr.isen.teamnougat.sweetquizz.listeners;

import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizzes;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;

/**
 * Created by dhawo on 06/11/2015.
 */
public interface ServerListener {
    public void onThemesRetrieved(Themes themes);
    public void onQuizzesRetrieved(ServerQuizzes serverQuizzes);
}
