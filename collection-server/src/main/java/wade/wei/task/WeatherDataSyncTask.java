package wade.wei.task;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import wade.wei.service.WeatherDataService;
import wade.wei.vo.City;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Administrator
 */
@Slf4j
@Configuration
public class WeatherDataSyncTask {

    @Autowired
    private WeatherDataService weatherDataCollectionService;

    @Scheduled(cron = "*/60 * * * * ?")
    protected void executeInternal(){
        log.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {

            // TODO 改为由城市数据API微服务提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);

        } catch (Exception e) {
            log.error("Exception!", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:" + cityId);

            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        log.info("Weather Data Sync Job. End！");
    }
}
