package com.example.app.SpringBootFruitShop;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.logging.Logger;


@SpringBootApplication
public class FruitShopApplication {

	private static final Logger LOGGER =
			Logger.getLogger(FruitShopApplication.class.getName());

	public static void main(String[] args) {


		new SpringApplicationBuilder(FruitShopApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		LOGGER.info("APP is running...");
	}
}
