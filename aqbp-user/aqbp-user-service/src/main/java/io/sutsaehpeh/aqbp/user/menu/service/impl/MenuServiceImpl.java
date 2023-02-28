package io.sutsaehpeh.aqbp.user.menu.service.impl;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.user.dto.MenuDTO;
import io.sutsaehpeh.aqbp.user.menu.service.MenuService;
import io.sutsaehpeh.aqbp.user.request.menu.MenuCreateRequest;
import io.sutsaehpeh.aqbp.user.request.menu.MenuPageRequest;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {


    @Override
    public MenuDTO createMenu(MenuCreateRequest request) {
        return null;
    }

    @Override
    public MenuDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<MenuDTO> queryMenuPage(MenuPageRequest request) {
        return null;
    }
}
