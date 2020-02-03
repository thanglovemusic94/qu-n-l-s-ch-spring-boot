package com.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.entities.Book;
import com.springboot.service.BookService;
import com.springboot.service.CategoryService;
import com.springboot.service.ManagerService;
import com.springboot.vo.BookVo;
import com.springboot.vo.CategoryVo;
import com.springboot.vo.ManagerVo;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/")
	public String index() {
		return "homeAdminPage";
	}

	// Show list danh mục
	@RequestMapping(value = "/category")
	public ModelAndView category() {
		ModelAndView m = new ModelAndView("categoryListAdminPage");
		m.addObject("allCategory", categoryService.getAllCategory());
		return m;
	}

	// Show list manager
	@RequestMapping(value = "/manager")
	public ModelAndView manager() {
		ModelAndView ma = new ModelAndView("managerListAdminPage");
		ma.addObject("allManager", managerService.getAllManager());
		return ma;
	}

	// Thêm danh mục
	@RequestMapping(value = "/category/create", method = RequestMethod.GET)
	public ModelAndView createCategory() {
		ModelAndView m = new ModelAndView("createCategoryAdminPage");
		m.addObject("categoryVo", new CategoryVo());
		return m;
	}

	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public ModelAndView storeCategory(@ModelAttribute("categoryVo") @Valid CategoryVo vo, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		boolean success = !result.hasErrors();
		if (success) {
			categoryService.createCategory(vo);
			redirectAttributes.addFlashAttribute("msg", "Đã thêm danh mục thành công!");
			return new ModelAndView("redirect:/admin/category");
		}
		return new ModelAndView("createCategoryAdminPage");
	}

	// Thêm manager
	@RequestMapping(value = "/manager/create", method = RequestMethod.GET)
	public ModelAndView createManager() {
		ModelAndView m = new ModelAndView("createManagerAdminPage");
		m.addObject("managerVo", new ManagerVo());
		return m;
	}

	@RequestMapping(value = "/manager/create", method = RequestMethod.POST)
	public ModelAndView storeManager(@ModelAttribute("managerVo") @Valid ManagerVo vo, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		boolean success = !result.hasErrors();
		if (success) {
			managerService.createManager(vo);
			redirectAttributes.addFlashAttribute("msg", "Đã thêm quản lý thành công!");
			return new ModelAndView("redirect:/admin/manager");
		}
		return new ModelAndView("createManagerAdminPage");
	}

	// Xóa danh mục
	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public RedirectView deleteCategory(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {
		boolean result = categoryService.deleteCategory(id);
		String message = result == true ? "Đã xóa thành công!" : "Xóa thất bại!";
		redirectAttributes.addFlashAttribute("msg", message);

		return new RedirectView("/admin/category", true);
	}
	
	// Xóa quản lý
		@RequestMapping(value = "/manager/delete/{id}", method = RequestMethod.GET)
		public RedirectView deleteManager(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {
			boolean result = managerService.deleteManager(id);
			String message = result == true ? "Đã xóa thành công!" : "Xóa thất bại!";
			redirectAttributes.addFlashAttribute("msg", message);

			return new RedirectView("/admin/manager", true);
		}

	// Sửa danh mục
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("id") String id) {
		ModelAndView m = new ModelAndView("editCategoryAdminPage");
		m.addObject("categoryVo", categoryService.getCategoryById(id));
		return m;
	}

	@RequestMapping(value = "/category/edit", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("categoryVo") @Valid CategoryVo vo, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		boolean success = !result.hasErrors();
		if (success) {
			categoryService.updateCategory(vo);
			redirectAttributes.addFlashAttribute("msg", "Đã sửa danh mục thành công!");
			return new ModelAndView("redirect:/admin/category");
		}

		return new ModelAndView("editCategoryAdminPage");
	}
	
	// Sửa quản lý
		@RequestMapping(value = "/manager/edit/{id}", method = RequestMethod.GET)
		public ModelAndView editManager(@PathVariable("id") String id) {
			ModelAndView m = new ModelAndView("editManagerAdminPage");
			m.addObject("managerVo", managerService.getManagerById(id));
			return m;
		}

		@RequestMapping(value = "/manager/edit", method = RequestMethod.POST)
		public ModelAndView editManager(@ModelAttribute("managerVo") @Valid ManagerVo vo, BindingResult result,
				final RedirectAttributes redirectAttributes) {

			boolean success = !result.hasErrors();
			if (success) {
				managerService.updateManager(vo);
				redirectAttributes.addFlashAttribute("msg", "Đã sửa thông tin quản lý thành công!");
				return new ModelAndView("redirect:/admin/manager");
			}

			return new ModelAndView("editManagerAdminPage");
		}

	// Show list sách
	@RequestMapping(value = "/book")
	public ModelAndView books() {
		ModelAndView m = new ModelAndView("bookListAdminPage");
		m.addObject("allBook", bookService.getAllBook());
		return m;
	}

	// Thêm sách
	@RequestMapping(value = "/book/create", method = RequestMethod.GET)
	public ModelAndView createBook() {
		ModelAndView m = new ModelAndView("createBookAdminPage");
		m.addObject("categoryList", categoryService.getAllCategory());
		m.addObject("bookVo", new BookVo());
		return m;
	}

	@RequestMapping(value = "/book/create", method = RequestMethod.POST)
	public String createBook(@ModelAttribute("bookVo") @Valid BookVo vo, BindingResult result,
			final RedirectAttributes redirectAttributes, ModelMap map) {
		if (result.hasErrors()) {
			map.addAttribute("msg", "Hãy nhập đầy đủ thông tin sách");
			return "createBookAdminPage";
		} else {
			// Chuyển vo sang book
			Book book = new Book();
			BeanUtils.copyProperties(vo, book);

			// 1. Đặt lại tên file cho book
			MultipartFile file = vo.getImg(); // lấy ra file ảnh up
			String fileName = file.getOriginalFilename(); // lấy ra tên file
			book.setImg(fileName); // lưu lại tên ảnh cho book

			// 2. Upload image
			try {
				// lấy ra tên thư mục
				String webappRoot = servletContext.getRealPath("/images/");
				// upload ảnh tới /static/images + tên file ảnh + đuôi ảnh
				String filename = webappRoot + fileName;

				// Chuyển MultipathFile sang dạng Stream Java để lưu lại vào đg dẫn
				// /static/images/anh1.png = localhost:8080/images/
				byte[] bytes = file.getBytes();
				Path path = Paths.get(filename);
				Files.write(path, bytes);

				// 3. Lưu
				bookService.save(book);
				redirectAttributes.addFlashAttribute("msg", "Đã thêm sách thành công!");
			} catch (IOException e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("msg", "Thêm sách thật bại!");
			}
			return "redirect:/admin/book";
		}
	}

	// Xóa sách
	@RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
	public RedirectView deleteBook(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		boolean result = bookService.deleteBook(id);

		String message = result == true ? "Đã xóa thành công" : "Xóa thất bại";
		redirectAttributes.addFlashAttribute("msg", message);

		return new RedirectView("/admin/book", true);
	}

	// Sửa sách
	@RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBook(@PathVariable("id") Integer id) {
		ModelAndView m = new ModelAndView("editBookAdminPage");
		m.addObject("categoryList", categoryService.getAllCategory());

		// convert entity to vo
		Book bookEntity = bookService.getBookById(id);
		BookVo vo = new BookVo();
		BeanUtils.copyProperties(bookEntity, vo);

		m.addObject("bookVo", vo);
		return m;
	}

	@RequestMapping(value = "/book/edit", method = RequestMethod.POST)
	public String editBook(@ModelAttribute("bookVo") BookVo vo, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		Book book = new Book();
		BeanUtils.copyProperties(vo, book);

		MultipartFile file = vo.getImg();
		String fileName = file.getOriginalFilename();
		book.setImg(fileName);

		try {
			String webappRoot = servletContext.getRealPath("/images/");
			String filename = webappRoot + fileName;

			byte[] bytes = file.getBytes();
			Path path = Paths.get(filename);
			Files.write(path, bytes);

			bookService.save(book);
			redirectAttributes.addFlashAttribute("msg", "Đã sửa sách thành công!");
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "Sửa sách thật bại!");
		}
		return "redirect:/admin/book";
	}

}
