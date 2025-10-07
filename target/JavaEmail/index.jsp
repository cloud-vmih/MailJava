<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Mail Demo</title>
    <link rel="stylesheet" type="text/css" href = "style.css">
</head>
<body>
<div>
    <form action="sendMail" method="post">
        <h2>Gửi mail bằng JavaMail nhé 😎</h2>
        <label>Người nhận:</label>
        <input type="email" name="email" required><br><br>

        <label>Tiêu đề:</label>
        <input type="text" name="subject" required><br><br>

        <label>Nội dung:</label>
        <textarea name="message" rows="5" cols="40" required></textarea><br><br>

        <button type="submit">Gửi</button>
    </form>
</div>
</body>
</html>
