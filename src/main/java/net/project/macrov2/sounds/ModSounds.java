package net.project.macrov2.sounds;

import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;

public class ModSounds
{

    public static final SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");
    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f,1f,
            MAGIC_BLOCK_BREAK,
            MAGIC_BLOCK_STEP,
            MAGIC_BLOCK_PLACE,
            MAGIC_BLOCK_HIT,
            MAGIC_BLOCK_FALL
            );

    public static final SoundEvent DAN_MUSIC_1 = registerSoundEvent("dan_music_1");
    public static final SoundEvent DAN_MUSIC_2 = registerSoundEvent("dan_music_2");

    public static final RegistryKey<JukeboxSong> DAN_MUSIC_1_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG,Identifier.of(Macrov2.MOD_ID,"dan_music_1"));
    public static final RegistryKey<JukeboxSong> DAN_MUSIC_2_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG,Identifier.of(Macrov2.MOD_ID,"dan_music_2"));


    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = Identifier.of(Macrov2.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id));
    }

    public static void registerSounds()
    {
        Macrov2.LOGGER.info("registering sounds for "+Macrov2.MOD_ID);
    }
}
