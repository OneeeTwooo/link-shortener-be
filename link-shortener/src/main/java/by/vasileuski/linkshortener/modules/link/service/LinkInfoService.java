package by.vasileuski.linkshortener.modules.link.service;

import by.vasileuski.linkshortener.modules.link.dto.CreateLinkInfoRequestDto;

public interface LinkInfoService {

    String getShortLink(CreateLinkInfoRequestDto createLinkInfoRequestDto);

}
