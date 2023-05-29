package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItems;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.services.CartItemService;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class CartScreen implements IScreen {
    private final RouterService router;
    private final CartService cartService;
    private final CartItemService cartItemService;
    private final ProductService prodService;
    private final Session session;
//    getProdService


    @Override
    public void start(Scanner scan) {
        String input = "";
        String itemQuantity = "";
        String itemChosen = "";
        Cart cart = cartService.findCartByCardId(session.getCart_id());
        List<CartItems> cartItems = cartItemService.findAllCartItemsByCartId(cart.getId());

        exit:
        {
            // cart screen emptied
            if (cartItems.isEmpty()) {
                cartIsEmpty(scan);
                break exit;
            }
        }
        // cart screen
        while (true) {
            clearScreen();
            System.out.println("Welcome to the Cart Screen!" + session.getUsername() + "!");
            System.out.println("Press [Enter] to continue...");

            // View Shopping cart
            System.out.println("View shopping cart");
            ViewCartItems(cartItems);

            // navigate through the options
            System.out.println("\nProduct name: "); // product name added
            System.out.println("Product price: "); // price of the product
            System.out.println("[r] Remove an item" + "[m] Modify an item");
            System.out.println("[c] Checkout");
            System.out.println("[b] Back to the main menu" + "[x] Exit");

            // chose option
            System.out.println("\nChoose option to navigate: ");
            switch (input.toLowerCase()) {
                case "b":
                    router.navigate("/home", scan);
                    break;
                case "m":
                    System.out.println("\nEnter item to modify");
                    itemQuantity = scan.nextLine();
                case "r":
                    while (true) {
                        // get cart item choice
                        itemChosen = getCartItemChosen(cartItems, scan);
                        if (itemChosen.equals("x")) {
                            break;
                        }

                        CartItems cartItem = cartItems.get(Integer.parseInt(itemChosen) - 1);

                        // update cart
                        cart.setTotalCost(cart.getTotalCost().subtract(cartItem.getPrice()));
                        cartService.updateCart(cart);

                        // delete cart item
                        cartItemService.deleteCartItem(cartItem.getId());
                        cartItems.remove(cartItem);

                        // empty cart screen
                        if (cartItems.isEmpty()) {
                            cartIsEmpty(scan);
                            // leave cart screen
                            break exit;
                        }

                        // successful removal
                        clearScreen();
                        System.out.println("Removal successful");
                        System.out.print("\nPress enter to continue...");
                        scan.nextLine();
                        break;
                    }
                    break;
                case "m":
                    while (true) {
                        // get cart item chosen
                        itemChosen = getCartItemChosen(cartItems, scan);
                        if (itemChosen.equals("x")) {
                            break;
                        }

                        CartItems cartItem = cartItems.get(Integer.parseInt(itemChosen) - 1);

                        // get new quantity
                        itemQuantity = getQuantity(cartItem.getQuantity(), cartItem.getStock(), scan);
                        if (itemQuantity.equals("x")) {
                            continue;
                        }

                        if (Integer.parseInt(itemQuantity) == 0) {
                            // update cart
                            cart.setTotalCost(cart.getTotalCost().subtract(cartItem.getPrice()));
                            cartService.updateCart(cart);

                            // delete cart item
                            cartItemService.deleteCartItem(cartItem.getId());
                            cartItems.remove(cartItem);

                            // success removal
                            clearScreen();
                            System.out.println("Removal successful");
                            System.out.print("\nPress enter to continue...");
                            scan.nextLine();

                            // show empty cart screen
                            if (cartItems.isEmpty()) {
                                cartIsEmpty(scan);
                                // leave cart screen
                                break;
                            }
                            break;
                        }

                        // update cart and cart item
                        updateCartAndCartItem(cart, cartItem, Integer.parseInt(itemQuantity));

                        clearScreen();
                        System.out.println("Update successful");
                        System.out.print("\nPress enter to continue...");
                        scan.nextLine();
                        break;
                    }
                    break;
                case "c":
                    // checkout
                    while (true) {
                        clearScreen();
                        System.out.println("Checking out...");
                        showCartItems(cartItems);
                        System.out.println("\n------------------------------------------------------------------");
                        System.out.println("\nTotal price: " + cart.getTotalCost());
                        System.out.print("\nContinue with purchase (y/n): ");

                        switch (scan.nextLine()) {
                            case "y":
                                // create order
                                Order order = new Order(OffsetDateTime.now(), cart.getTotalCost(),
                                        session.getId());
//                                orderService.createOrder(order);

                                for (CartItems cartItem : cartItems) {
                                    // create order item
                                    OrderItem orderItem = new OrderItem(cartItem.getName(), cartItem.getQuantity(),
                                            cartItem.getPrice(),
                                            order.getId(), cartItem.getProduct_id());
//                                    orderService.createOrderItem(orderItem);

                                    // delete cart item
                                    cartService.deleteCartItem(cartItem.getId());

                                    // update product stock
                                    Optional<Product> product = prodService
                                            .getProductById(orderItem.getProduct_id());
                                    product.get().setStock(product.get().getStock() - orderItem.getQuantity());
                                    prodService.updateProduct(product.get());
                                }

                                // update cart
                                cart.setTotalCost(BigDecimal.valueOf(0));
                                cartService.updateCart(cart);

                                // process payment
                                clearScreen();
                                System.out.println("Your order was processed successfully!");
                                System.out.print("\nEnter to continue...");
                                scan.nextLine();
                                break exit;
                            case "n":
                                break;
                            default:
                                continue;
                        }
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
 }


    /***************************** Helper Methods *****************************/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void cartIsEmpty(Scanner scan) {
        // if cart is not found, navigate back to menu
        exit:
        {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Cart Screen!" + session.getUsername() + "!");
                System.out.println("Press [Enter] to continue...");
                System.out.println("\nThere is nothing in your cart....");
                System.out.println("\n[1] Continue shopping");
                System.out.println("Press [x] to return");

                System.out.println("\nChoose an option: ");
                switch (scan.nextLine()) {
                    case "1":
                        //navigate to product screen
                        router.navigate("/home", scan);
                        break exit;
                    case "x":
                        break exit;
                    default:
                        break;
                }

            }
        }
    }

    public void ViewCartItems(List<CartItems> cartItems) {
        // looping through the cart items
        for(CartItems cartItem : cartItems){
            System.out.println("\n" +
                    cartItem.getName() +
                    " - Price: $" +
                    cartItem.getPrice() +
                    "Quantity: " +
                    cartItem.getQuantity());
        }
    }

}
