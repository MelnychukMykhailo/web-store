package online.books.webstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import online.books.webstore.dto.book.BookDtoWithoutCategoryIds;
import online.books.webstore.dto.category.CategoryDto;
import online.books.webstore.dto.category.CreateCategoryRequestDto;
import online.books.webstore.exception.EntityNotFoundException;
import online.books.webstore.mapper.BookMapper;
import online.books.webstore.mapper.CategoryMapper;
import online.books.webstore.model.Category;
import online.books.webstore.repository.CategoryRepository;
import online.books.webstore.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final BookMapper bookMapper;

    @Override
    public List<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find category by id: " + id)));
    }

    @Override
    public CategoryDto save(CreateCategoryRequestDto requestDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toModel(requestDto)));
    }

    @Override
    public CategoryDto update(Long id, CreateCategoryRequestDto requestDto) {
        if (!categoryRepository.existsById(id)) {
            new EntityNotFoundException("Can't update category by id: " + id);
        }
        Category category = categoryMapper.toModel(requestDto);
        category.setId(id);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            new EntityNotFoundException("Can't delete category by id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    public List<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't find category by id: " + id);
        }
        return categoryRepository.getBooksByCategoryId(id)
                .stream()
                .map(bookMapper::toDtoWithoutCategoryIds)
                .toList();
    }
}
