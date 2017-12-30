package com.lzk.web;

import com.lzk.Exception.UserNameNotMatchPasswordException;
import com.lzk.dao.EmployeeDao;
import com.lzk.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

/**
 * Created by lzk on 2017/12/29 14:18
 * Description:
 */
@Controller
public class MyCoverter {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/testConversionServiceConverter",method = RequestMethod.POST)
    public String testCoverter(@RequestParam("employee") Employee employee){
        System.out.println("save:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/testHttpMessageConverter",method = RequestMethod.POST)
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "hello world! " + new Date();
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte [] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/resource/css.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    @RequestMapping(value = "/testFileUpload", method = RequestMethod.POST)
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc :" + desc);
        System.out.println("getOriginalFilename :" + file.getOriginalFilename());
        System.out.println("getInputStream :" + file.getInputStream());
        return "success";
    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
        System.out.println("Result:" + (10 / i));
        return "success";
    }

    /**
     * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题.
     * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常,
     * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常.
     * @param ex
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception ex){
        System.out.println("出异常了:" +ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }

/*    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handlerArithmeticExceptionq(Exception ex){
        System.out.println("[出异常了]:" +ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }*/

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY,reason = "用户名密码不匹配！！")
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i == 13){
            throw new UserNameNotMatchPasswordException();
        }
        return "success";
    }

    @RequestMapping(value = "/testDefaultHandlerExceptionResolver",method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver");
        return "success";
    }

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String[] arrs = new String[10];
        System.out.println(arrs[i]);
        return "success";
    }
}
