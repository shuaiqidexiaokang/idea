package com.lzk.controller;

import com.lzk.entity.Student;
import com.lzk.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by lzk on 2017/12/27 12:53
 * Description:RequestMappingTest
 */
@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/RequestMappingTest")
@Controller
public class RequestMappingTest {

    private final String SUCCESS = "success";

    /**
     * 1. @RequestMapping 除了修饰方法, 还可来修饰类
     * 2. 1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
     * 2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
     * 若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * 常用：使用method属性指定请求方式
     *
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 了解：使用 params 和 headers 可以更加精确的映射请求。 params 和 headers 支持简单的表达式。
     *
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username", "password!=123"}, headers = {"Accept-Language=zh-CN,zh;q=0.9,ar;q=0.8"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * Ant风格资源地址
     * ?：匹配文件名中的一个字符
     * *：匹配文件名中的任意字符
     * **：匹配多层路径
     *
     * @return
     */
    @RequestMapping(value = "/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * @param id
     * @return
     * @PathVariable 可以映射URL中的占位符到目标方法的参数中
     */
    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable" + id);
        return SUCCESS;
    }

    /**
     * * Rest 风格的 URL.
     * 以 CRUD 为例:
     * 新增: /order POST
     * 修改: /order/1 PUT     update?id=1
     * 获取:/order/1 GET      get?id=1
     * 删除: /order/1 DELETE  delete?id=1
     *
     * 如何发送 PUT 请求和 DELETE 请求呢 ?
     * 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     *
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRestGet/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("testRestGet:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestPost",method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("testRestPost");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestDelete/{id}",method = RequestMethod.DELETE)
    @ResponseBody()
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("testRestDelete:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestPut/{id}",method = RequestMethod.PUT)
    @ResponseBody()
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRestPut:" + id);
        return SUCCESS;
    }

    /**
     * @param username
     * @param password
     * @return
     * @RequestParam 来映射请求参数
     * value：请求参数的参数名
     * required：该参数是否必须，默认值为true
     * defaultValue:请求参数默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false, defaultValue = "admin") String username,
                                   @RequestParam("password") String password) {
        System.out.println("testRequestParam,username:" + username + ",password:" + password);
        return SUCCESS;
    }

    /**
     * @param al
     * @return
     * @RequestHeader 映射请求头
     * 用法同@RequestParam
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al) {
        System.out.println("testRequestHeader,Accept-Language:" + al);
        return SUCCESS;
    }

    /**
     * @param sessionId
     * @return
     * @CookieValue 映射一个Cookie值
     * 用法同@RequestParam
     */
    @RequestMapping(value = "/CookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("CookieValue,JSESSIONID:" + sessionId);
        return SUCCESS;
    }

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值。支持级联属性。
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/testPojo", method = RequestMethod.POST)
    public String testPojo(User user) {
        System.out.println("testPojo:" + user);
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是 ModelAndView 类型
     * 其中可以包含视图和模型的信息
     * SpringMVC 会把 ModelAndView 的 model 中的数据放入到 request域对象中
     *
     * @return
     */
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * 目标方法可以添加Mpa 类型（实际上也可以是Model 类型或 ModelMap类型）的参数
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     *  @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
     *
     * 注意: 该注解只能放在类的上面. 而不能修饰放方法.
     * @param map
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("tom","123",17,"231");
        map.put("user", user);
        map.put("school", "zjlg");
        return SUCCESS;
    }

    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     * 2). SpringMVC 会以 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     * @param id
     * @param map
     */
/*    @ModelAttribute
    public void getStudent(@RequestParam("id") Integer id,Map<String,Object> map){
        if (id !=null){
            Student student = new Student(1,"Tom","123456","tom@qq.com",12);
            System.out.println("模拟从数据库中获取一个对象：" + student);
            map.put("student",student);
        }
    }*/

    /**
     * 运行流程:
     * 1. 执行 @ModelAttribute 注解修饰的方法: 从数据库中取出对象, 把对象放入到了 Map 中. key 为: student
     * 2. SpringMVC 从 Map 中取出 Student 对象, 并把表单的请求参数赋给该 Student 对象的对应属性.
     * 3. SpringMVC 把上述对象传入目标方法的参数.
     *
     * 注意: 在 @ModelAttribute 修饰的方法中, 放入到 Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
     *
     * SpringMVC 确定目标方法 POJO 类型入参的过程
     * 1. 确定一个 key:
     * 1). 若目标方法的 POJO 类型的参数木有使用 @ModelAttribute 作为修饰, 则 key 为 POJO 类名第一个字母的小写
     * 2). 若使用了  @ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的 value 属性值.
     * 2. 在 implicitModel 中查找 key 对应的对象, 若存在, 则作为入参传入
     * 1). 若在 @ModelAttribute 标记的方法中在 Map 中保存过, 且 key 和 1 确定的 key 一致, 则会获取到.
     * 3. 若 implicitModel 中不存在 key 对应的对象, 则检查当前的 Handler 是否使用 @SessionAttributes 注解修饰,
     * 若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会从 HttpSession 中来获取 key 所
     * 对应的 value 值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常.
     * 4. 若 Handler 没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value 值中不包含 key, 则
     * 会通过反射来创建 POJO 类型的参数, 传入为目标方法的参数
     * 5. SpringMVC 会把 key 和 POJO 类型的对象保存到 implicitModel 中, 进而会保存到 request 中.
     *
     * 源代码分析的流程
     * 1. 调用 @ModelAttribute 注解修饰的方法. 实际上把 @ModelAttribute 方法中 Map 中的数据放在了 implicitModel 中.
     * 2. 解析请求处理器的目标参数, 实际上该目标参数来自于 WebDataBinder 对象的 target 属性
     * 1). 创建 WebDataBinder 对象:
     * ①. 确定 objectName 属性: 若传入的 attrName 属性值为 "", 则 objectName 为类名第一个字母小写.
     * *注意: attrName. 若目标方法的 POJO 属性使用了 @ModelAttribute 来修饰, 则 attrName 值即为 @ModelAttribute
     * 的 value 属性值
     *
     * ②. 确定 target 属性:
     * 	> 在 implicitModel 中查找 attrName 对应的属性值. 若存在, ok
     * 	> *若不存在: 则验证当前 Handler 是否使用了 @SessionAttributes 进行修饰, 若使用了, 则尝试从 Session 中
     * 获取 attrName 所对应的属性值. 若 session 中没有对应的属性值, 则抛出了异常.
     * 	> 若 Handler 没有使用 @SessionAttributes 进行修饰, 或 @SessionAttributes 中没有使用 value 值指定的 key
     * 和 attrName 相匹配, 则通过反射创建了 POJO 对象
     *
     * 2). SpringMVC 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性.
     * 3). *SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel.
     * 近而传到 request 域对象中.
     * 4). 把 WebDataBinder 的 target 作为参数传递给目标方法的入参.
     * @param student
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return SUCCESS;
    }

    @RequestMapping(value = "/testView")
    public String testView() {
        System.out.println("testView");
        return "helloView";
    }

    @RequestMapping(value = "/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }



}
