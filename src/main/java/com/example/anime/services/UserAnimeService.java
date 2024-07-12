package com.example.anime.services;

import com.example.anime.domain.Anime;
import com.example.anime.domain.User;
import com.example.anime.domain.UserAnime;
import com.example.anime.domain.UserAnimeId;
import com.example.anime.repos.UserAnimeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserAnimeService {

    private final UserAnimeRepo userAnimeRepo;

    public void saveAnimeToUser(User user, Anime anime, String status) {
        UserAnimeId userAnimeId = new UserAnimeId(user.getId(), anime.getId());
        UserAnime userAnime = new UserAnime(userAnimeId, status, user, anime);
        userAnimeRepo.save(userAnime);
    }

    public List<Anime> getUserAnimeList(User user, String status) {
        return userAnimeRepo.findByUser(user).stream()
                .filter(userAnime -> !Objects.equals(status, "все") ? userAnime.getStatus().equals(status) : !userAnime.getStatus().isEmpty())
                .map(UserAnime::getAnime)
                .toList();
    }

}
