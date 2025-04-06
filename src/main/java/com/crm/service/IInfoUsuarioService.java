package com.crm.service;

import java.util.List;

import com.crm.dto.InfoUsuarioDTO;

public interface IInfoUsuarioService {
    InfoUsuarioDTO save(InfoUsuarioDTO usuarioDTO);
    InfoUsuarioDTO update(InfoUsuarioDTO usuarioDTO);
    InfoUsuarioDTO findById(Object usuarioDTO);
    void delete(InfoUsuarioDTO usuarioDTO);
    List<InfoUsuarioDTO> findAll();
    InfoUsuarioDTO findByName(String usuario);
}
