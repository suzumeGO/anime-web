package com.example.anime.mappers;

import com.example.anime.DTO.requested.RequestedAnimeDTO;
import com.example.anime.DTO.requested.SingleAnimeDTO;
import com.example.anime.domain.Anime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimeDomainToDTOMapper {
    SingleAnimeDTO domainToDTO(Anime anime);
    @Mapping(target = "pagination", expression = "java(getPagination(anime))")
    @Mapping(target = "data", expression = "java(animeDomainToDTOAnime(anime.getContent()))")
    RequestedAnimeDTO domainListToDTO(Page<Anime> anime);

    List<RequestedAnimeDTO.Anime> animeDomainToDTOAnime(List<Anime> anime);

    default RequestedAnimeDTO.Pagination getPagination(Page<Anime> anime) {
        RequestedAnimeDTO.Pagination pagination = new RequestedAnimeDTO.Pagination();
        pagination.setCurrentPage(anime.getPageable().getPageNumber() + 1);
        pagination.setHasNextPage(anime.hasNext());
        pagination.setLastPage(anime.getTotalPages());
        RequestedAnimeDTO.Pagination.Items items = new RequestedAnimeDTO.Pagination.Items();
        items.setCount(anime.getNumberOfElements());
        items.setTotal((int) anime.getTotalElements());
        items.setPerPage(anime.getPageable().getPageSize());
        pagination.setItems(items);
        return pagination;
    }

    default Page<Anime> createPage(List<Anime> anime, Pageable pageRequest) {
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), anime.size());
        List<Anime> pageContent = anime.subList(start, end);
        return new PageImpl<>(pageContent, pageRequest, anime.size());
    }

}
