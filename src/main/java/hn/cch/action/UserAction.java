package hn.cch.action;

import hn.cch.entity.User;
import hn.cch.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction {

    private UserService userService;

    private String userName;
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //主页跳转
    public String index() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getSession().getAttribute("userLogin") != null) {
            return "successful";
        } else {
            return "failed";
        }

    }

    //用户登陆
    public String login() {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        User user = new User(userName, userPwd);
        User userLogin = userService.login(user);

        if (userLogin != null) {
            // 保存登陆状态
            request.getSession().setAttribute("userLogin", userLogin);
            try {
                //重定向
                String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "successful";
        } else {
            try {
                //重定向
                String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "failed";
        }


    }
    //用户退出
    public String logout() {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        //清除
        request.getSession().removeAttribute("userLogin");
        try {
            //重定向
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
