package com.shiro.jpa.utils;

import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
/**
 * 发送邮件工具类
 * 配置
 * spring:
 *   mail:
 *     host: smtp.qq.com # QQ邮箱smtp主机
 *     port: 587 #端口号465或587
 *     username: test@qq.com 发送人邮箱
 *     password: dxbrcmxjktzqbbhj  # POP3/SMTP提供的授权码，如果邮箱服务商没有授权码，可以使用密码代替
 *     protocol: smtp
 *     default-encoding: UTF-8
 * 使用
 * 注入 @Autowired TemplateEngine templateEngine; MailUtils
 *         MailBean mailBean = MailBean.getMailBean();
 *         Context context = new Context();
 *         context.setVariable("user", "Tyrone");
 *         String content = templateEngine.process("emailTemplate", context);
 *         mailBean.setSubject("SpringBoot集成JavaMail实现邮件发送");
 *         mailBean.setText(content);
 *         mailUtil.sendMailTemplate(mailBean)
 */
@Component
public class MailUtils {
        @Autowired
        private JavaMailSender mailSender; // 自动注入的Bean
        @Value("${spring.mail.username}")
        private String sender; // 读取配置文件中的参数

        /**
         * 发送邮件测试方法
         */
        public void sendMail() {
            SimpleMailMessage mimeMessage = new SimpleMailMessage();
            mimeMessage.setFrom(sender);
            mimeMessage.setTo(sender);
            mimeMessage.setSubject("SpringBoot集成JavaMail实现邮件发送");
            mimeMessage.setText("SpringBoot集成JavaMail实现邮件发送正文");
            mailSender.send(mimeMessage);
        }

        /**
         * 发送简易邮件
         *
         * @param mailBean
         */
        public void sendMail(MailBean mailBean) {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            try {
                helper.setFrom(sender);
                helper.setTo(sender);
                helper.setSubject(mailBean.getSubject());
                helper.setText(mailBean.getText());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            mailSender.send(mimeMessage);
        }

        /**
         * 发送邮件-邮件正文是HTML
         * @param mailBean
         */
//      String html =
//              "<html>"
//              + "<body>"
//              + "<p><h1>SpringBoot集成JavaMail实现正文为HTML的邮件发送功能</h1></p>"
//              + "</body>"
//              + "</html>";
//      mailBean.setSubject("SpringBoot集成JavaMail实现邮件发送");
//      mailBean.setText(html);
//      mailUtil.sendMailHtml(mailBean);
        public void sendMailHtml(MailBean mailBean) {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            try {
                helper.setFrom(sender);
                helper.setTo(sender);
                helper.setSubject(mailBean.getSubject());
                helper.setText(mailBean.getText(), true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            mailSender.send(mimeMessage);
        }

        /**
         * 发送邮件-附件邮件
         * @param mailBean
         */
//      String filePath="/Users/shanglishuai/Downloads/Jietu20180727-144621@2x.jpg";
//      FileSystemResource file = new FileSystemResource(new File(filePath));
//      String attachmentFilename = filePath.substring(filePath.lastIndexOf(File.separator));
//      mailBean.setSubject("SpringBoot集成JavaMail实现邮件发送");
//      mailBean.setText("SpringBoot集成JavaMail实现附件邮件发送");
//      mailBean.setFile(file);
//      mailBean.setAttachmentFilename(attachmentFilename);
//      mailUtil.sendMailAttachment(mailBean)
        public void sendMailAttachment(MailBean mailBean) {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(sender);
                helper.setTo(sender);
                helper.setSubject(mailBean.getSubject());
                helper.setText(mailBean.getText(), true);
                // 增加附件名称和附件
                helper.addAttachment(mailBean.getAttachmentFilename(), mailBean.getFile());
                mailSender.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        /**
         * 内联资源（静态资源）邮件发送
         * 由于邮件服务商不同，可能有些邮件并不支持内联资源的展示
         * 在测试过程中，新浪邮件不支持，QQ邮件支持
         * 不支持不意味着邮件发送不成功，而且内联资源在邮箱内无法正确加载
         *
         * @param mailBean
         */
//      String filePath="/Users/shanglishuai/Downloads/Jietu20180727-144621@2x.jpg";
//      String contentId = UUID.randomUUID().toString().replace("-", "");
//      /*
//       * <img src=\'cid:" + contentId + "\' >
//       * cdi:是固定的，其后连接内联资源的的ID（保证唯一即可）
//       */
//      String content = "<html><body>内联资源邮件发送：<img src=\'cid:" + contentId + "\' ></body></html>";
//      FileSystemResource file = new FileSystemResource(new File(filePath));
//      mailBean.setSubject("SpringBoot集成JavaMail实现邮件发送");
//      mailBean.setText(content);
//      mailBean.setFile(file);
//      mailBean.setContentId(contentId);
//      mailUtil.sendMailInline(mailBean);
        public void sendMailInline(MailBean mailBean) {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(sender);
                helper.setTo(sender);
                helper.setSubject(mailBean.getSubject());

                /*
                 * 内联资源邮件需要确保先设置邮件正文，再设置内联资源相关信息
                 */
                helper.setText(mailBean.getText(), true);
                helper.addInline(mailBean.getContentId(), mailBean.getFile());

                mailSender.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        /**
         * 模板邮件发送
         *
         * @param mailBean
         */
        public void sendMailTemplate(MailBean mailBean) {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(sender);
                helper.setTo(sender);
                helper.setSubject(mailBean.getSubject());
                helper.setText(mailBean.getText(), true);
                mailSender.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }
}
