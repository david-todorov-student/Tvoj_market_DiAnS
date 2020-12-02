namespace Tvoj_Market_Prototip.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial1 : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Markets", "Longitude", c => c.String());
            AlterColumn("dbo.Markets", "Latitude", c => c.String());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Markets", "Latitude", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Markets", "Longitude", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
