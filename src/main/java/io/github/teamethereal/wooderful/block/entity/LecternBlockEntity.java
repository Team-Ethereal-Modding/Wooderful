package io.github.teamethereal.wooderful.block.entity;

import io.github.teamethereal.wooderful.block.WooderfulLectern;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.LecternScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

import java.util.Objects;

public class LecternBlockEntity extends BlockEntity implements Clearable, NamedScreenHandlerFactory {
    private final Inventory inventory = new Inventory() {
        public int size() {
            return 1;
        }

        public boolean isEmpty() {
            return LecternBlockEntity.this.book.isEmpty();
        }

        public ItemStack getStack(int int_1) {
            return int_1 == 0 ? LecternBlockEntity.this.book : ItemStack.EMPTY;
        }

        public ItemStack removeStack(int int_1, int int_2) {
            if (int_1 == 0) {
                ItemStack stack = LecternBlockEntity.this.book.split(int_2);
                if (LecternBlockEntity.this.book.isEmpty()) {
                    LecternBlockEntity.this.onBookRemoved();
                }
                return stack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public ItemStack removeStack(int int_1) {
            if (int_1 == 0) {
                ItemStack stack = LecternBlockEntity.this.book;
                LecternBlockEntity.this.book = ItemStack.EMPTY;
                LecternBlockEntity.this.onBookRemoved();
                return stack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public void setStack(int int_1, ItemStack stack) {
        }

        public int getMaxCountPerStack() {
            return 1;
        }

        public void markDirty() {
            LecternBlockEntity.this.markDirty();
        }

        public boolean canPlayerUse(PlayerEntity player) {
            if (LecternBlockEntity.this.world.getBlockEntity(LecternBlockEntity.this.pos) != LecternBlockEntity.this) {
                return false;
            } else {
                return !(player.squaredDistanceTo(LecternBlockEntity.this.pos.getX() + 0.5D, LecternBlockEntity.this.pos.getY() + 0.5D, LecternBlockEntity.this.pos.getZ() + 0.5D) > 64.0D) && LecternBlockEntity.this.hasBook();
            }
        }

        public boolean isValid(int int_1, ItemStack stack) {
            return false;
        }

        public void clear() {
        }
    };
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int int_1) {
            return int_1 == 0 ? LecternBlockEntity.this.currentPage : 0;
        }

        public void set(int int_1, int int_2) {
            if (int_1 == 0) {
                LecternBlockEntity.this.setCurrentPage(int_2);
            }

        }

        public int size() {
            return 1;
        }
    };
    private ItemStack book;
    private int currentPage;
    private int pageCount;

    public LecternBlockEntity(BlockEntityType<?> blockEntityType) {
        super(blockEntityType);
        this.book = ItemStack.EMPTY;
    }

    public ItemStack getBook() {
        return this.book;
    }

    public boolean hasBook() {
        Item item = this.book.getItem();
        return item == Items.WRITABLE_BOOK || item == Items.WRITTEN_BOOK;
    }

    public void setBook(ItemStack stack) {
        this.setBook(stack, null);
    }

    private void onBookRemoved() {
        this.currentPage = 0;
        this.pageCount = 0;
        WooderfulLectern.setHasBook(Objects.requireNonNull(this.getWorld()), this.getPos(), this.getCachedState(), false);
    }

    public void setBook(ItemStack stack, PlayerEntity player) {
        this.book = this.resolveBook(stack, player);
        this.currentPage = 0;
        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.markDirty();
    }

    private void setCurrentPage(int int_1) {
        int int_2 = MathHelper.clamp(int_1, 0, this.pageCount - 1);
        if (int_2 != this.currentPage) {
            this.currentPage = int_2;
            this.markDirty();
            WooderfulLectern.setPowered(Objects.requireNonNull(this.getWorld()), this.getPos(), this.getCachedState());
        }
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getComparatorOutput() {
        float float_1 = this.pageCount > 1 ? this.getCurrentPage() / (this.pageCount - 1.0F) : 1.0F;
        return MathHelper.floor(float_1 * 14.0F) + (this.hasBook() ? 1 : 0);
    }

    private ItemStack resolveBook(ItemStack stack, PlayerEntity player) {
        if (this.world instanceof ServerWorld && stack.getItem() == Items.WRITTEN_BOOK) {
            WrittenBookItem.resolve(stack, this.getCommandSource(player), player);
        }
        return stack;
    }

    private ServerCommandSource getCommandSource(PlayerEntity player) {
        String name;
        Object component;
        if (player == null) {
            name = "Lectern";
            component = new LiteralText("Lectern");
        } else {
            name = player.getName().getString();
            component = player.getDisplayName();
        }
        Vec3d vec3d_1 = new Vec3d(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D);
        return new ServerCommandSource(CommandOutput.DUMMY, vec3d_1, Vec2f.ZERO, (ServerWorld)this.world, 2, name, (Text)component, this.world.getServer(), player);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag.contains("Book", 10)) {
            this.book = this.resolveBook(ItemStack.fromTag(tag.getCompound("Book")), null);
        } else {
            this.book = ItemStack.EMPTY;
        }
        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.currentPage = MathHelper.clamp(tag.getInt("Page"), 0, this.pageCount - 1);
    }

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (!this.getBook().isEmpty()) {
            tag.put("Book", this.getBook().toTag(new CompoundTag()));
            tag.putInt("Page", this.currentPage);
        }
        return tag;
    }

    public void clear() {
        this.setBook(ItemStack.EMPTY);
    }

    public ScreenHandler createMenu(int int_1, PlayerInventory inventory, PlayerEntity player) {
        return new LecternScreenHandler(int_1, this.inventory, this.propertyDelegate);
    }

    public Text getDisplayName() {
        return new TranslatableText("container.lectern");
    }
}