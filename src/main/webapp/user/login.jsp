
<%@include file="/common/header.jsp"%>

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>Login</h2>
                        <form action="/WholeSalesWeb<%=ControllerPaths.EMPRESA%>" method="post">
                        		<input type="hidden" name="<%=ParameterNames.ACTION %>" value="<%=ActionNames.SIGN_IN%>"/>
                            <div class="group-input">
                                <label for="username">Username or email address *</label>
                                <input type="text" name="<%=ParameterNames.EMAIL%>" id="username">
                            </div>
                            <div class="group-input">
                                <label for="pass">Password *</label>
                                <input type="password" name="<%=ParameterNames.CONTRASENA%>" id="pass">
                            </div>
                            <div class="group-input gi-check">
                                <div class="gi-more">
                                    <label for="save-pass">
                                        Save Password
                                        <input type="checkbox" id="save-pass">
                                        <span class="checkmark"></span>
                                    </label>
                                    <a href="#" class="forget-pass">Forget your Password</a>
                                </div>
                            </div>
                            <button type="submit" class="site-btn login-btn">Sign In</button>
                        </form>
                        <div class="switch-login">
                            <a href="/WholeSalesWeb/user/register.jsp" class="or-login">Or Create An Account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Register Form Section End -->

<%@include file="/common/footer.jsp"%>