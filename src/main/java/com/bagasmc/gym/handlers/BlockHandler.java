package com.bagasmc.gym.handlers;

import com.bagasmc.gym.blocks.BlockDumbbell;

public class BlockHandler {
	public static void initialize() {
		BlockDumbbell.init();
		BlockDumbbell.register();
	}
}
