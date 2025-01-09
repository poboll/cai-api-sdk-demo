package com.caiths.caiapisdkdemo.controller;

import com.caiths.swiftweb.common.BaseResponse;
import com.caiths.swiftweb.common.ResultUtils;
import com.caiths.swiftweb.exception.BusinessException;
import com.caiths.caiapisdk.client.CaiApiClient;
import com.caiths.caiapisdk.exception.ApiException;
import com.caiths.caiapisdk.model.params.HoroscopeParams;
import com.caiths.caiapisdk.model.params.IpInfoParams;
import com.caiths.caiapisdk.model.params.RandomWallpaperParams;
import com.caiths.caiapisdk.model.params.WeatherParams;
import com.caiths.caiapisdk.model.request.HoroscopeRequest;
import com.caiths.caiapisdk.model.request.IpInfoRequest;
import com.caiths.caiapisdk.model.request.RandomWallpaperRequest;
import com.caiths.caiapisdk.model.request.WeatherRequest;
import com.caiths.caiapisdk.model.response.LoveResponse;
import com.caiths.caiapisdk.model.response.PoisonousChickenSoupResponse;
import com.caiths.caiapisdk.model.response.RandomWallpaperResponse;
import com.caiths.caiapisdk.model.response.ResultResponse;
import com.caiths.caiapisdk.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: mdo
 * @Date: 2024年12月30日 14:30
 * @Version: 1.0
 * @Description:
 */
@RequestMapping("/invoke")
@RestController
@Slf4j
public class InvokeController {
    @Resource
    private ApiService apiService;


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoup")
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() {
        CaiApiClient caiApiClient = new CaiApiClient("ed0d3e1b244f84caa22783dd782b8e9f", "f1eac0de371858b4ac461e7aae6f9ffd");
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup(caiApiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoupKey")
    public PoisonousChickenSoupResponse getPoisonousChickenSoupKey(CaiApiClient caiApiClient) {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup(caiApiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }

    /**
     * 获取毒鸡汤未设置密钥
     *
     * @return {@link BaseResponse}<{@link PoisonousChickenSoupResponse}>
     */
    @GetMapping("/getPoisonousChickenSoupNotSetKey")
    public BaseResponse<PoisonousChickenSoupResponse> getPoisonousChickenSoupNotSetKey() {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup();
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            throw new com.caiths.swiftweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(poisonousChickenSoup);
    }

    /**
     * 随机情话
     *
     * @return {@link BaseResponse}<{@link LoveResponse}>
     */
    @GetMapping("/loveTalk/easyWeb")
    public BaseResponse<LoveResponse> getLoveTalkEasyWeb() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(loveResponse);
    }

    @GetMapping("/loveTalk")
    public LoveResponse getLoveTalk() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    @GetMapping("/loveTalk/setKey")
    public LoveResponse getLoveTalkSetKey() {
        LoveResponse loveResponse;
        try {
            CaiApiClient caiApiClient = new CaiApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
            loveResponse = apiService.randomLoveTalk(caiApiClient);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    /**
     * 获取星座运势
     *
     * @param horoscopeParams 星座参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/getHoroscopeEasyWeb")
    public BaseResponse<ResultResponse> getHoroscopeEasyWeb(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.caiths.swiftweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(horoscope);
    }

    @GetMapping("/getHoroscope")
    public ResultResponse getHoroscope(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.caiths.swiftweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    @GetMapping("/getHoroscope/setKey")
    public ResultResponse getHoroscopeSetKey(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        CaiApiClient caiApiClient = new CaiApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(caiApiClient, horoscopeRequest);
        } catch (ApiException e) {
            throw new com.caiths.swiftweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    /**
     * 获取ip信息
     * <p>
     * // * @param ipInfoParams ip信息参数
     *
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/ipInfo/easyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(CaiApiClient caiApiClient, IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(caiApiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo/toEasyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo")
    public ResultResponse getIpInfo(IpInfoParams ipInfoParams) {
        CaiApiClient caiApiClient = new CaiApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(caiApiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    /**
     * 获取天气信息
     *
     * @param weatherParams ip信息参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/weatherInfo/EasyWeb")
    public BaseResponse<ResultResponse> getWeatherInfoEasyWeb(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/weatherInfo")
    public ResultResponse getWeatherInfo(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/weatherInfo/setKey")
    public ResultResponse getWeatherInfoSetKey(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        CaiApiClient caiApiClient = new CaiApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(caiApiClient, weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/setKey")
    public RandomWallpaperResponse getRandomWallpaperSetKey(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        CaiApiClient caiApiClient = new CaiApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(caiApiClient, randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper")
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/easyWeb")
    public BaseResponse<RandomWallpaperResponse> getRandomWallpaperEasyWeb(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }
}
