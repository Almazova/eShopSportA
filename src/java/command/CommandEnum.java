/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author asus
 */
public enum CommandEnum {

    GO_TO_WEBSITE_MAIN_PAGE{
                {
                    this.command = new GoToWebsiteMainPageCommand();
                }
            },
    CLOTHING {
                {
                    this.command = new ShowCatalogComand();
                }
            },
    SOUVENIRS {
                {
                    this.command = new ShowCatalogComand();
                }
            },
    SOUND_ATTRIBUTES {
                {
                    this.command = new ShowCatalogComand();
                }
            },
    BOOKS_AND_MEDIA {
                {
                    this.command = new ShowCatalogComand();
                }
            },
    FLAGS_AND_PENNANTS {
                {
                    this.command = new ShowCatalogComand();
                }
            },
    ADD_TO_CART {
                {
                    this.command = new AddedProductToCartCommand();
                }
            },
    UPDATE_QUANTITY {
                {
                    this.command = new UpdatedQuantityInCartComand();
                }
            },
    CONTINUE_VIEW {
                {
                    this.command = new ContinuedCatalogViewCommand();
                }
            },
    SHOW_CART {
                {
                    this.command = new ShowCartCommand();
                }
            },
    CLEAR_CART {
                {
                    this.command = new CleaningCartCommand();
                }
            },
    GO_TO_CHECKOUT {
                {
                    this.command = new GoToCheckoutCommand();
                }
            },
    ADD_ORDER {
                {
                    this.command = new NewOrderCommand();
                }
            },
    DELETE_GOODS_FROM_CART {
                {
                    this.command = new DeleteGoodsFromCartCommand();
                }
            },
    GO_TO_ADMIN_MAIN_PAGE {
                {
                    this.command = new GoToAdminMainPageCommand();
                }
            },
    GO_TO_ADMIN_ORDERS_RECEIVED {
                {
                    this.command = new GoToAdminOrdersReceivedCommand();
                }
            },
    GO_TO_EXECUTES_ORDERS {
                {
                    this.command = new GoToExecutesOrdersCommand();
                }
            },
    CONFIRMATION_OF_ORDER {
                {
                    this.command = new ConfirmationOfOrderCommand();
                }
            },
    REJECTION_THE_ORDER {
                {
                    this.command = new RejectionTheOrderCommand();
                }
            },
    CONFIRME_DELIVERY_ORDER {
                {
                    this.command = new ConfirmeDeliveryOrderCommand();
                }
            },
    REJECTION_DELIVERY_OF_ORDER {
                {
                    this.command = new RejectionDeliveryOfOrderCommand();
                }
            },
    EDIT_ORDER_BY_ADMIN {
                {
                    this.command = new EditOrderByAdminCommand();
                }
            },
    UPDATE_QUANTITY_BY_ADMIN {
                {
                    this.command = new UpdateQuantityByAdminCommand();
                }
            },
    DELETE_GOODS_FROM_ORDER_BY_ADMIN {
                {
                    this.command = new DeleteGoodsFromOrderByAdminCommand();
                }
            },
    SAVE_CHANGES_TO_THE_ORDER {
                {
                    this.command = new SaveChangesToTheOrderCommand();
                }
            },
    GO_TO_ADMIN_DELETE_EDIT_GOODS{
                {
                    this.command = new GoToAdminDeleteEditGoodsCommand();
                }
            },
    MARK_THE_ORDER_AS_NOT_AVAILABLE{
                {
                    this.command = new MarkTheOrderAsNotAvailableCommand();
                }
            },
    MARK_THE_ORDER_AS_IN_STOCK{
                {
                    this.command = new MarkTheOrderAsInStockCommand();
                }
            },
    EDIT_GOOS_BY_ADMIN{
                {
                    this.command = new EditGoodsByAdminCommand();
                }
            },
    SAVE_CHANGES_TO_THE_GOODS{
                {
                    this.command = new SaveChangesToTheGoodsCommand();
                }
    },
    GO_TO_ADMIN_ADD_GOODS{
                {
                    this.command = new GoToAdminAddGoodsCommand();
                }
    },
    ADD_GOODS_BY_ADMIN{
                {
                    this.command = new AddGoodsByAdminCommand();
                }
    },
    OPEN_IMG{
                {
                    this.command = new OpenImgCommand();
                }
    },
    PASSWORDCHECK{
                {
                    this.command = new PasswordCheckCommand();
                }
    },
    EXIT{
                {
                    this.command = new LogoutAdminCommand();
                }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
