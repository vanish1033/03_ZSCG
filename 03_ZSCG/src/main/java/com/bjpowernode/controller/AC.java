package com.bjpowernode.controller;

import com.bjpowernode.bean.StudenT;
import com.bjpowernode.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AC {

    /*若用对象当参数来接受浏览器访问，浏览器中
      全部参数都可以不写（因为对象初始化时有默认值）
      但是写了就要赋值（除String类型->不赋值默认为 ""）


    基本类型包括上string当参数接受浏览器访问时，
    String类型可以不写（默认为null），或写了不赋值（默认为 ""）
    但是基本类型必须写了赋值
    */

    /*
    普通测试
     */

    @RequestMapping(value = "/test1")
    public ModelAndView andView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("Hello", "aaa");
        mv.setViewName("firstjsp");
        System.out.println("被访问");
        return mv;
    }


    /*
    请求中携带参数
     */
//    @RequestMapping(value = "/test2",params = {"name","age"}) 请求参数中必须要有name和age两个属性
//    @RequestMapping(value = "/test2",params = {"!name","age"}) 请求参数中必须要有age属性，但不能有name属性
//    @RequestMapping(value = "/test2",params = {"name=jack","age=23"}) 请求参数中必须要有name和age两个属性,
//                                                                      且必须等于这个值
    @RequestMapping(value = "/test2")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("Hello", "aaa");
        mv.setViewName("firstjsp");
        System.out.println("被访问");
        return mv;
    }


    /*
    使用方法参数接受请求中参数
     */

    @RequestMapping(value = "/test3")
    public String test3(String name, int age, Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("Hello", name);
        mv.setViewName("firstjsp");
        System.out.println("被访问");
        System.out.println(name);
        System.out.println(age);
        return "redirect:/test.jsp";
    }


    /*
   使用对象接受请求中参数
    */
    @RequestMapping("/test4")
    public String test4(StudenT stu) {
//        ModelAndView mv = new ModelAndView();
////        mv.addObject("Hello", stu.getName());
//        mv.addObject("World", stu.getAge());
////        mv.setViewName("firstjsp");
//        System.out.println("被访问");
//        System.out.println(student.getName());
//        System.out.println(student.getAge());
//        model.addAttribute("world", stu.getAge());
        return "forward:/test.jsp";//默认是请求转发
    }


    /*
   使用对象接受请求中参数(测试传入日期类数据，在Student类里有属性接受)
    */
    @RequestMapping(value = "/test5")
    public ModelAndView test5(StudenT stu) {
        System.out.println("被访问1");
        ModelAndView mv = new ModelAndView();
        mv.addObject("Hello", stu.getName());
        mv.addObject("World", stu.getAge());
        mv.addObject("time", stu.getLocalDate());
        mv.addObject("k", stu.getSchool().getAddress());
        mv.addObject("m", stu.getSchool().getSchoolname());
        mv.setViewName("firstjsp");
        System.out.println(stu.getLocalDate());
        return mv;
    }


    /**
     * 测试路径变量
     */
    @RequestMapping(value = "/{username}/{password}/test6")
    public ModelAndView test6(@PathVariable("username") String username, @PathVariable("password") int password) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("password", password);
        mv.setViewName("firstjsp");

        return mv;
    }


    /**
     * 返回值为String，跳转到外部网站
     */
    @RequestMapping(value = "/test7")
    public String test7() {

        return "bjpowernode";
    }


    /**
     * 返回json格式
     */
    @RequestMapping(value = "/test8")
    @ResponseBody//这个注解会把返回值变为json格式，放到返回体里
    public Map test8() {

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        return map;
    }


    /*
   测试 hibernate-validator 后台校验
    */
    @RequestMapping(value = "/test9")
    public ModelAndView test9(@Validated User user, BindingResult br /*这个对象的作用是把所有的校验异常保存起来*/) {
        System.out.println("9号被访问");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("firstjsp");

        List<ObjectError> allErrors = br.getAllErrors();
        if (allErrors != null && allErrors.size() > 0) {
            mav.setViewName("forward:/index.jsp");
            FieldError nameError = br.getFieldError("name");
            FieldError ageError = br.getFieldError("age");
            //姓名校验未通过
            if (nameError != null) {
                mav.addObject("nameError", nameError.getDefaultMessage());
            }
            //年龄校验未通过
            if (ageError != null) {
                mav.addObject("ageError", ageError.getDefaultMessage());
            }

        }

        mav.addObject("name", user.getName());
        mav.addObject("age", user.getAge());
//        mav.setViewName("firstjsp");

        return mav;
    }


    /**
     * 使用apache commons组件读取前台提交的图片文件
     */
    @RequestMapping(value = "/test10")
    @DateTimeFormat
//    @RequestParam注解是为了把前端传过来的参数的name交给后台具有同样name的接受参数的对象
    public ModelAndView test10(@RequestParam MultipartFile photo, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("key", "图片上传失败");
        mav.setViewName("firstjsp");
        if (!photo.isEmpty()) {

            //限制文件上传类型
            if ("image/jpeg".equals(photo.getContentType())) {

                //获取服务器中文件上传路径
                String path = session.getServletContext().getRealPath("/upload");

                //获取文件名称
                String originalFilename = photo.getOriginalFilename();

                //创建文件
                File file = new File(path, originalFilename);

                //上传文件
                photo.transferTo(file);

                //反馈用户
                mav.addObject("key", "图片上传成功！");


            }

        }

        return mav;
    }


}
