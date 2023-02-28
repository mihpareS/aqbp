package io.sutsaehpeh.aqbp.user.menu.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.user.dto.MenuDTO;
import io.sutsaehpeh.aqbp.user.request.menu.MenuCreateRequest;
import io.sutsaehpeh.aqbp.user.request.menu.MenuPageRequest;

public interface MenuService {

    MenuDTO createMenu(MenuCreateRequest request);

    MenuDTO findById(Long id);

    Page<MenuDTO> queryMenuPage(MenuPageRequest request);
}
