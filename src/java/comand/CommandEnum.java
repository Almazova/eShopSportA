/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

/**
 *
 * @author asus
 */
public enum CommandEnum {

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
    GO_TO_CHECKOUT{
                {
                    this.command = new GoToCheckoutCommand();
                }
            },
    ADD_ORDER{
                {
                    this.command = new NewOrderCommand();
                }
            };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
