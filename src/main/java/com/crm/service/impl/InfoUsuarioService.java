package com.crm.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.InfoUsuarioDAO;
import com.crm.dto.InfoUsuarioDTO;
import com.crm.mapper.InfoUsuarioMapper;
import com.crm.model.InfoUsuario;
import com.crm.service.IInfoUsuarioService;

@Stateless
public class InfoUsuarioService implements IInfoUsuarioService {

    @Inject
    private InfoUsuarioDAO dao;

    @Override
    public InfoUsuarioDTO save(InfoUsuarioDTO dto) {
        InfoUsuario entity = InfoUsuarioMapper.toEntity(dto);
        dao.save(entity);
        return InfoUsuarioMapper.toDTO(entity);
    }

    @Override
    public InfoUsuarioDTO update(InfoUsuarioDTO dto) {
        InfoUsuario entity = InfoUsuarioMapper.toEntity(dto);
        InfoUsuario updated = dao.update(entity);
        return InfoUsuarioMapper.toDTO(updated);
    }

    @Override
    public InfoUsuarioDTO findById(Object id) {
        return InfoUsuarioMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(InfoUsuarioDTO dto) {
        InfoUsuario entity = InfoUsuarioMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<InfoUsuarioDTO> findAll() {
        return dao.findAll().stream()
                  .map(InfoUsuarioMapper::toDTO)
                  .collect(Collectors.toList());
    }

	@Override
	public InfoUsuarioDTO findByName(String usuario) {
	      InfoUsuario res = dao.findByName(usuario);      
	      return InfoUsuarioMapper.toDTO(res);
	}
}
