package ouer.caihe.maven.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	@RequestMapping(value="/android_login")
	@ResponseBody
	public String androidLoginTest(){
		return "{\"status\": 1,\"token\":\"123456\"}";
	}
	
	@RequestMapping(value="/android_send_pass")
	@ResponseBody
	public String androidSendPassTest(){
		return "{\"status\": 1}";
	}
	
	@RequestMapping(value="/android_upload_contacts")
	@ResponseBody
	public String androidUploadContactsTest(){
		return "{\"status\": 1}";
	}
	
	@RequestMapping(value="/android_timeline")
	@ResponseBody
	public String androidTimeLineTest(){
		return "{\"status\": 1,\"page\":1,\"perpage\":10,\"items\":[{\"msg\":\"I am a XB1\",\"phone_md5\":\"md5xxx\",\"msgId\":\"123456\"},{\"msg\":\"I am a XB2\",\"phone_md5\":\"md5xxx\",\"msgId\":\"1234567\"},{\"msg\":\"I am a XB3\",\"phone_md5\":\"md5xxx\",\"msgId\":\"12345678\"}]}";
	}
	
	@RequestMapping(value="/android_get_comment")
	@ResponseBody
	public String androidGetCommentTest(){
		return "{\"status\": 1,\"page\":1,\"perpage\":10,\"msgId\":\"123456\",\"items\":[{\"content\":\"You are right1!\",\"phone_md5\":\"md5xxx\"},{\"content\":\"You are right2!\",\"phone_md5\":\"md5xxx\"},{\"content\":\"You are right3!\",\"phone_md5\":\"md5xxx\"}]}";
	}
	@RequestMapping(value="/android_pub_comment")
	@ResponseBody
	public String androidSendCommentTest(){
		return "{\"status\": 1}";
	}
}
