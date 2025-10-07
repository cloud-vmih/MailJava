# Base image có sẵn Tomcat
FROM tomcat:9.0-jdk17

# Xóa mấy webapp mặc định để đỡ rác
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR export ra từ Eclipse (đặt tên ROOT.war để chạy ở "/")
COPY target/JavaEmail.war /usr/local/tomcat/webapps/ROOT.war

# Tomcat listen port 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]