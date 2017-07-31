package zw.co.tndangana.hrtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zw.co.tndangana.hrtp.domain.ict.SelfBusinessHelpFromSocialMedia;
import zw.co.tndangana.hrtp.service.SelfBusinessHelpFromSocialMediaService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/11/17.
 */
@Controller
@RequestMapping("/selfBusinessHelpFromSocialMedia/")
public class SelfBusinessHelpFromSocialMediaController {
    @Resource
    private SelfBusinessHelpFromSocialMediaService selfBusinessHelpFromSocialMediaService;
}
